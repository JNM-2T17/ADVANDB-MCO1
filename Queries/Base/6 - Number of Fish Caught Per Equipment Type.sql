SELECT mun, zone, brgy,SUM(aquaequip_line) AS totalequip
		, SUM(aquani_vol) AS totalvol
        , SUM(aquani_vol)/SUM(aquaequip_line) AS CatchPerEquip
FROM hpq_aquaequip AA, hpq_aquani AP, hpq_hh H
WHERE aquaequiptype = 2 AND aquanitype = 2 AND H.id = AA.hpq_hh_id 
	AND H.id = AP.hpq_hh_id
GROUP BY H.mun,H.zone,H.brgy
