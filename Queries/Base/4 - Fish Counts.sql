SELECT H.mun,H.zone,H.brgy, SUM(aquani_vol) fishcount
FROM hpq_hh H, hpq_aquani A
WHERE H.id = A.hpq_hh_id AND aquanitype = 2
GROUP BY H.mun,H.zone,H.brgy
HAVING COUNT(H.id) > 0