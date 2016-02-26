CREATE INDEX HIndex2
ON db_hpq.hpq_aquaequip (aquaequip_line);
CREATE INDEX HIndex3
ON db_hpq.hpq_aquani (aquanitype);

CREATE OR REPLACE VIEW geoHH AS
	SELECT id, mun, zone, brgy 
	FROM hpq_hh;

CREATE OR REPLACE VIEW aquaeq AS
SELECT hpq_hh_id,aquaequip_line,aquaequiptype
		FROM hpq_aquaequip;

CREATE OR REPLACE VIEW aquani AS
	SELECT hpq_hh_id, aquanitype, aquani_vol 
	FROM hpq_aquani;

DELIMITER $$

CREATE PROCEDURE query6(
	IN equip INT,
    IN anitype INT,
    IN minCount INT)
BEGIN
select mun, zone, brgy,SUM(aquaequip_line) AS totalequip
		, SUM(aquani_vol) AS totalvol
        , SUM(aquani_vol)/SUM(aquaequip_line) AS CatchPerEquip
from ((SELECT hpq_hh_id,aquaequip_line
		FROM aquaeq
        WHERE aquaequiptype = equip) AA INNER JOIN
	(SELECT hpq_hh_id, aquani_vol 
		FROM aquani
        WHERE aquanitype = anitype)AP
	ON AA.hpq_hh_id = AP.hpq_hh_id) INNER JOIN
    hpq_hh H
	ON H.id = AA.hpq_hh_id
group by H.mun,H.zone,H.brgy
HAVING CatchPerEquip > minCount;
END$$

DELIMITER ;

CALL query6(2,2,0);

ALTER TABLE hpq_aquaequip DROP INDEX HIndex2;
ALTER TABLE hpq_aquani DROP INDEX HIndex3;
