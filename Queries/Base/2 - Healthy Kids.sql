SELECT country_resid, prov_resid_code, mnutind,COUNT(mnutind) nutCount
FROM hpq_mem
WHERE mnutind <= 1
GROUP BY country_resid, prov_resid_code,mnutind
HAVING nutCount > 0