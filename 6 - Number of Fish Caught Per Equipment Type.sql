select mun, zone, brgy, aquaequiptype, SUM(aquaequip_line), aquanitype, SUM(aquani_vol) 
from hpq_aquaequip aa, hpq_aquani ap, hpq_hh h
where h.id = aa.hpq_hh_id && h.id = ap.hpq_hh_id
group by H.mun,H.zone,H.brgy
