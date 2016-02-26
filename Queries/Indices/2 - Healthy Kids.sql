CREATE INDEX HIndex
ON db_hpq.hpq_mem (mnutind);

SELECT country_resid, prov_resid_code, mnutind,COUNT(mnutind) nutCount
FROM (SELECT country_resid, prov_resid_code, mnutind
		FROM hpq_mem
		WHERE mnutind <= 1) A
GROUP BY country_resid, prov_resid_code,mnutind
HAVING nutCount > 0;

ALTER TABLE db_hpq.hpq_mem DROP INDEX HIndex;