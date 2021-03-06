select mun, zone, brgy,SUM(aquaequip_line) AS totalequip
		, SUM(aquani_vol) AS totalvol
        , SUM(aquani_vol)/SUM(aquaequip_line) AS CatchPerEquip
from ((SELECT hpq_hh_id,aquaequip_line
		FROM hpq_aquaequip
        WHERE aquaequiptype = 2) AA INNER JOIN
	(SELECT hpq_hh_id, aquani_vol 
		FROM hpq_aquani
        WHERE aquanitype = 2)AP
	ON AA.hpq_hh_id = AP.hpq_hh_id) INNER JOIN
    (SELECT id, mun, zone, brgy
		FROM hpq_hh) H
	ON H.id = AA.hpq_hh_id
group by H.mun,H.zone,H.brgy
