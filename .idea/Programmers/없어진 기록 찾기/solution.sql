SELECT o.animal_id, o.name from animal_outs o left join animal_ins i on o.animal_id = i.animal_id
where i.animal_id is NULL;

# SELECT id, name from (
# select o.animal_id id, o.name name, i.animal_id nid
# from animal_outs o left join animal_ins i
# on o.animal_id = i.animal_id
# ) sub
# where nid is NULL;