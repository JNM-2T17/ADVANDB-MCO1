CREATE INDEX HIndex
ON db_hpq.hpq_mem (mnutind);

CREATE OR REPLACE VIEW kidHealthThresh AS
SELECT country_resid, prov_resid_code, mnutind
FROM hpq_mem;

DELIMITER $$

CREATE PROCEDURE query2(IN minNut INT, IN minCount INT)
BEGIN
SELECT country_resid, prov_resid_code, mnutind,COUNT(mnutind) nutCount
FROM kidHealthThresh
WHERE mnutind <= minNut
GROUP BY country_resid, prov_resid_code,mnutind
HAVING nutCount > minCount;
END$$

DELIMITER ;

CALL query2(1,0);

ALTER TABLE db_hpq.hpq_mem DROP INDEX HIndex;