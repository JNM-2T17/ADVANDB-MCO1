CREATE INDEX HIndex2
ON db_hpq.hpq_death (mdeady);

CREATE OR REPLACE VIEW geoHH AS
	SELECT id, mun, zone, brgy 
	FROM hpq_hh;

CREATE OR REPLACE VIEW deathSxAge AS
SELECT hpq_hh_id, mdeadsx, mdeadage,mdeady
FROM hpq_death;
        
DELIMITER $$

CREATE PROCEDURE query3(IN deady INT,IN minCount INT)
BEGIN
SELECT H.mun,H.zone,H.brgy, mdeadsx, AVG(mdeadage) avg_death_age
FROM geoHH H INNER JOIN 
	(SELECT hpq_hh_id, mdeadsx, mdeadage
		FROM deathSxAge
        WHERE mdeady = deady) D 
	ON H.id = D.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy,mdeadsx
HAVING AVG(mdeadage) > minCount;
END$$

DELIMITER ;

CALL query3(10,0);

ALTER TABLE hpq_death DROP INDEX HIndex2;