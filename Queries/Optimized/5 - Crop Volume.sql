SELECT H.mun,H.zone,H.brgy, SUM(crop_vol) AS totalcrop, SUM(alp_area) AS totalArea, SUM(crop_vol)/SUM(alp_area) AS cropDensity
FROM (SELECT id,mun,zone,brgy
		FROM hpq_hh) H INNER JOIN
        ((SELECT hpq_hh_id,alp_area 
				FROM hpq_alp ) A INNER JOIN 
		(SELECT hpq_hh_id,crop_vol
		FROM hpq_crop) C 
		ON A.hpq_hh_id = C.hpq_hh_id) 
	ON H.id = A.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy
HAVING cropDensity > 0