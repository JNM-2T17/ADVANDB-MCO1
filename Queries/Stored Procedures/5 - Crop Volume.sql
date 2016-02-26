CREATE INDEX HIndex3
ON db_hpq.hpq_crop (croptype);

CREATE OR REPLACE VIEW geoHH AS
	SELECT id, mun, zone, brgy 
	FROM hpq_hh;

CREATE OR REPLACE VIEW alp AS
SELECT hpq_hh_id,alp_area 
FROM hpq_alp;

CREATE OR REPLACE VIEW crop AS
SELECT hpq_hh_id,crop_vol, croptype
FROM hpq_crop;

SELECT H.mun,H.zone,H.brgy, SUM(crop_vol) AS totalcrop
		, SUM(alp_area) AS totalArea
        , SUM(crop_vol)/SUM(alp_area) AS cropDensity
FROM geoHH H INNER JOIN
        (alp A INNER JOIN 
		(SELECT hpq_hh_id,crop_vol
        FROM crop
        WHERE croptype = 2) C 
		ON A.hpq_hh_id = C.hpq_hh_id) 
	ON H.id = A.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy
HAVING cropDensity > 0;

ALTER TABLE hpq_crop DROP INDEX HIndex3;