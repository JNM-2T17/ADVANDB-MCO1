CREATE INDEX HIndex2
ON db_hpq.hpq_death (mdeady);

CREATE OR REPLACE VIEW geoHH AS
	SELECT id, mun, zone, brgy 
	FROM hpq_hh;

CREATE OR REPLACE VIEW deathSxAge AS
SELECT hpq_hh_id, mdeadsx, mdeadage,mdeady
FROM hpq_death;
        
SELECT H.mun,H.zone,H.brgy, mdeadsx, AVG(mdeadage) avg_death_age
FROM geoHH H INNER JOIN 
	(SELECT hpq_hh_id, mdeadsx, mdeadage
		FROM deathSxAge
        WHERE mdeady = 10) D 
	ON H.id = D.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy,mdeadsx
HAVING AVG(mdeadage) > 0;

ALTER TABLE hpq_death DROP INDEX HIndex2;