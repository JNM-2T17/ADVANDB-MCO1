CREATE INDEX HIndex1
ON db_hpq.hpq_hh (id, mun, zone, brgy);
CREATE INDEX HIndex2
ON db_hpq.hpq_death (hpq_hh_id, mdeadsx, mdeadage);

SELECT H.mun,H.zone,H.brgy, mdeadsx, AVG(mdeadage) avg_death_age
FROM (SELECT id, mun, zone, brgy 
		FROM hpq_hh) H INNER JOIN 
	(SELECT hpq_hh_id, mdeadsx, mdeadage 
		FROM hpq_death) D 
	ON H.id = D.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy,mdeadsx
HAVING AVG(mdeadage) > 0;

ALTER TABLE hpq_hh DROP INDEX HIndex1;
ALTER TABLE hpq_death DROP INDEX HIndex2;