CREATE INDEX HIndex2
ON db_hpq.hpq_aquani (aquanitype);

CREATE OR REPLACE VIEW geoHH AS
	SELECT id, mun, zone, brgy 
	FROM hpq_hh;

CREATE OR REPLACE VIEW aquani AS
	SELECT hpq_hh_id, aquanitype, aquani_vol 
	FROM hpq_aquani;

DELIMITER $$

CREATE PROCEDURE query4(IN type INT,IN minCount INT)
BEGIN
SELECT H.mun,H.zone,H.brgy, SUM(aquani_vol) fishcount
FROM geoHH H INNER JOIN 
	(SELECT hpq_hh_id,aquani_vol FROM aquani
        WHERE aquanitype = type) A
	ON H.id = A.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy
HAVING COUNT(H.id) > minCount;
END$$

DELIMITER ;

CALL query4(2,0);

ALTER TABLE hpq_aquani DROP INDEX HIndex2;