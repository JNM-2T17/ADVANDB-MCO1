CREATE INDEX HIndex2
ON db_hpq.hpq_aquani (aquanitype);

SELECT H.mun,H.zone,H.brgy, aquanitype, COUNT(H.id) fishcount
FROM (SELECT id,mun,zone,brgy 
		FROM hpq_hh) H INNER JOIN 
	(SELECT hpq_hh_id, aquanitype 
		FROM hpq_aquani
        WHERE aquanitype = 6) A
	ON H.id = A.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy,aquanitype
HAVING COUNT(H.id) > 0;

ALTER TABLE hpq_aquani DROP INDEX HIndex2;