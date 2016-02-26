CREATE OR REPLACE VIEW SimpleHH AS
SELECT id, mun, zone, brgy 
FROM hpq_hh;

CREATE OR REPLACE VIEW commonPhilhealth AS
SELECT PEM.hpq_hh_id, PEM.phiheal_empl_mem_refno AS mem_refno
FROM ((((SELECT hpq_hh_id, phiheal_spon_mem_refno
		FROM hpq_phiheal_spon_mem)PSM INNER JOIN
	(SELECT hpq_hh_id, phiheal_empl_mem_refno 
    FROM hpq_phiheal_empl_mem )PEM
		ON PSM.hpq_hh_id = PEM.hpq_hh_id
			AND PSM.phiheal_spon_mem_refno = PEM.phiheal_empl_mem_refno) INNER JOIN
	(SELECT hpq_hh_id, phiheal_indiv_mem_refno 
    FROM hpq_phiheal_indiv_mem )PIM 
		ON PEM.hpq_hh_id = PIM.hpq_hh_id
			AND PEM.phiheal_empl_mem_refno = PIM.phiheal_indiv_mem_refno) INNER JOIN
	(SELECT hpq_hh_id, phiheal_life_mem_refno
	FROM hpq_phiheal_life_mem ) PLM
		ON PIM.hpq_hh_id = PLM.hpq_hh_id
			AND PIM.phiheal_indiv_mem_refno = PLM.phiheal_life_mem_refno );

SELECT mun,zone,brgy,COUNT(id) benefCount
FROM SimpleHH INNER JOIN commonPhilhealth
        ON id = hpq_hh_id
GROUP BY mun,zone,brgy
HAVING benefCount > 0