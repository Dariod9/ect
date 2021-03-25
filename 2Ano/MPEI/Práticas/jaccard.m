function distJ = jaccard(elem, elem2)


tmp = length(intersect(elem, elem2));

distJ = 1 - (tmp/(length(elem))  + length(elem2 - tmp));