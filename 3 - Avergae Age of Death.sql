SELECT H.mun,H.zone,H.brgy, mdeadsx, AVG(mdeadage) avg_death_age
FROM hpq_hh H, hpq_death D
WHERE H.id = D.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy,mdeadsx
HAVING AVG(mdeadage) > 0