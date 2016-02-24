select h.id, aquaequiptype, aquaequip_line, aquani_line, aquanitype
from hpq_aquaequip aa, hpq_aquani ap, hpq_hh h
where h.id = aa.hpq_hh_id && h.id = ap.hpq_hh_id
group by h.id, aquaequiptype, aquanitype