select mun, zone, brgy,SUM(aquaequip_line) AS totalequip
		, SUM(aquani_vol) AS totalvol
        , SUM(aquani_vol)/SUM(aquaequip_line) AS CatchPerEquip
from hpq_aquaequip AA, hpq_aquani AP, hpq_hh H
WHERE aquaequiptype = 2 AND aquanitype = 2 AND H.id = AA.hpq_hh_id 
	AND H.id = AP.hpq_hh_id
group by H.mun,H.zone,H.brgy
