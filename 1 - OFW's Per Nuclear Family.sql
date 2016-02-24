SELECT mun, zone, brgy, purok
		, SUM(nnucfam) AS `Nuclear Families`, SUM(nofw) AS OFWs
        , SUM(nofw) / SUM(nnucfam) AS `Average OFW's per Nuclear Family`
FROM db_hpq.hpq_hh
GROUP BY mun, zone, brgy, purok
HAVING SUM(nofw) > 0
