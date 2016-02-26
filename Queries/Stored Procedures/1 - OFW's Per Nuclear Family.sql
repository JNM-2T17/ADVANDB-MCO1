CREATE INDEX HIndex
ON db_hpq.hpq_hh (nnucfam);

CREATE OR REPLACE VIEW hhnucfam AS
SELECT mun, zone, brgy, purok, nnucfam, nofw
		FROM db_hpq.hpq_hh
		WHERE nnucfam > 0;

DELIMITER $$
CREATE PROCEDURE query1(IN minCount INT)
BEGIN
SELECT mun, zone, brgy, purok
		, SUM(nnucfam) AS `Nuclear Families`, SUM(nofw) AS OFWs
        , SUM(nofw) / SUM(nnucfam) AS `Average OFW's per Nuclear Family`
FROM hhnucfam
GROUP BY mun, zone, brgy, purok
HAVING SUM(nofw) > minCount;
END$$

DELIMITER ;

CALL query1(0);

ALTER TABLE hpq_hh DROP INDEX HIndex;
