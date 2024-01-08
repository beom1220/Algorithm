SELECT i.ingredient_type,
       sum(f.total_order)
           as total_order from icecream_info i
                                   join first_half f on i.flavor = f.flavor
group by i.ingredient_type