Select vendas.stor_name, vendas.by_store from
				(SELECT	stores.stor_name, COUNT(sales.title_id) as by_store from
					(sales join stores on sales.stor_id=stores.stor_id) GROUP BY stores.stor_name) as vendas
				join
				(SELECT COUNT(titles.title_id) as total FROM titles) as titulos
				on titulos.total=vendas.by_store

