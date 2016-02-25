SELECT country_resid, prov_resid_code, mnutind,COUNT(mnutind) nutCount
FROM (SELECT country_resid, prof_resid_code, mnutind
		FROM hpq_mem
		WHERE mnutind <= 2)
GROUP BY country_resid, prov_resid_code,mnutind
HAVING nutCount > 0