select distinct r_employee, r_address, rcc, sum(quantity) as sales
from raw_data left join (select uuid, r_address as rcc from user left join (select distinct a_uuid, r_address from raw_data) as rd on main_address = a_uuid) as rc
                        on e_uuid = uuid group by r_employee order by sales desc