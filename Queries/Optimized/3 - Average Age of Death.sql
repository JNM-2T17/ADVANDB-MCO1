SELECT H.mun,H.zone,H.brgy, mdeadsx, AVG(mdeadage) avg_death_age
FROM (SELECT id, mun, zone, brgy 
		FROM hpq_hh)H INNER JOIN 
	(SELECT hpq_hh_id, mdeadsx, mdeadage 
		FROM hpq_death
        WHERE mdeady = 17) D 
	ON H.id = D.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy,mdeadsx
HAVING AVG(mdeadage) > 0