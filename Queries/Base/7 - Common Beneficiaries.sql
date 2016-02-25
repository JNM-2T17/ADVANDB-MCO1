SELECT H.mun,H.zone,H.brgy,COUNT(H.id) benefCount
FROM hpq_hh H, hpq_phiheal_spon_mem PSM, hpq_phiheal_empl_mem PEM
		,hpq_phiheal_indiv_mem PIM, hpq_phiheal_life_mem PLM
WHERE H.id = PSM.hpq_hh_id AND H.id = PEM.hpq_hh_id AND H.id = PIM.hpq_hh_id 
		AND H.id = PLM.hpq_hh_id
        AND PSM.phiheal_spon_mem_refno = PEM.phiheal_empl_mem_refno
        AND PEM.phiheal_empl_mem_refno = PIM.phiheal_indiv_mem_refno 
        AND PIM.phiheal_indiv_mem_refno = PLM.phiheal_life_mem_refno 
GROUP BY H.mun,H.zone,H.brgy
HAVING benefCount > 0