SELECT authors.au_fname, authors.au_lname FROM (titles JOIN (authors JOIN titleauthor on authors.au_id=titleauthor.au_id) on titles.title_id=titleauthor.title_id) GROUP BY authors.au_fname, authors.au_lname HAVING COUNT(titles.type)>1