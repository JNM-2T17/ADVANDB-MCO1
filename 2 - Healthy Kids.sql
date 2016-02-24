SELECT country_resid, prov_resid_code, mnutind,COUNT(mnutind) nutCount
FROM hpq_mem
WHERE mnutind <= 2
GROUP BY country_resid, prov_resid_code,mnutind