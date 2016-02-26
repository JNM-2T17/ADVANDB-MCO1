SELECT H.mun,H.zone,H.brgy, SUM(crop_vol) AS totalcrop
		, SUM(alp_area) AS totalArea, SUM(crop_vol)/SUM(alp_area) AS cropDensity
FROM hpq_hh H, hpq_alp A, hpq_crop C
WHERE H.id = A.hpq_hh_id AND H.id = C.hpq_hh_id AND croptype = 2
GROUP BY H.mun,H.zone,H.brgy
HAVING cropDensity > 0