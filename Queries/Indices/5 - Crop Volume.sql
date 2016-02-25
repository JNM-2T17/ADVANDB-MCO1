CREATE INDEX HIndex1
ON db_hpq.hpq_hh (id, mun, zone, brgy);
CREATE INDEX HIndex2
ON db_hpq.hpq_alp (hpq_hh_id, alp_area);
CREATE INDEX HIndex3
ON db_hpq.hpq_crop (hpq_hh_id, crop_vol);

SELECT H.mun,H.zone,H.brgy, SUM(crop_vol) AS totalcrop
		, SUM(alp_area) AS totalArea
        , SUM(crop_vol)/SUM(alp_area) AS cropDensity
FROM (SELECT id,mun,zone,brgy
		FROM hpq_hh) H INNER JOIN
        ((SELECT hpq_hh_id,alp_area 
				FROM hpq_alp ) A INNER JOIN 
		(SELECT hpq_hh_id,crop_vol
		FROM hpq_crop) C 
		ON A.hpq_hh_id = C.hpq_hh_id) 
	ON H.id = A.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy
HAVING cropDensity > 0;

ALTER TABLE hpq_hh DROP INDEX HIndex1;
ALTER TABLE hpq_alp DROP INDEX HIndex2;
ALTER TABLE hpq_crop DROP INDEX HIndex3;