Select titles.title,authors.au_fname, au_lname, ytd_sales*royalty*royaltyper/10000 as revenue from (authors join (titles join titleauthor on titles.title_id=titleauthor.title_id) on authors.au_id= titleauthor.au_id) Order by titles.title