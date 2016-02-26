CREATE INDEX HIndex
ON db_hpq.hpq_mem (mnutind);

CREATE OR REPLACE VIEW kidHealthThresh AS
SELECT country_resid, prov_resid_code, mnutind
FROM hpq_mem;

SELECT country_resid, prov_resid_code, mnutind,COUNT(mnutind) nutCount
FROM kidHealthThresh
WHERE mnutind <= 1
GROUP BY country_resid, prov_resid_code,mnutind
HAVING nutCount > 0;

ALTER TABLE db_hpq.hpq_mem DROP INDEX HIndex;