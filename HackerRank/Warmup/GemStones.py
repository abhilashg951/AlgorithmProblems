num_rocks = int(raw_input())
element_in_num_rocks_map = {}

for _ in xrange(num_rocks):
    elements_in_rock = []
    
    for element in raw_input():
        if element in elements_in_rock: 
            continue
            
        elements_in_rock.append(element)
        
        if element not in element_in_num_rocks_map:
            element_in_num_rocks_map[element] = 1
        else:
            element_in_num_rocks_map[element] = element_in_num_rocks_map[element] + 1

print len([x for x in element_in_num_rocks_map if element_in_num_rocks_map[x] >= num_rocks])