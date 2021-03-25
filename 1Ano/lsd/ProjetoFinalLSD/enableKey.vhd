library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity enableKey	is
	port(	clk	:	in		std_logic;
			enEn	:	in		std_logic;
			en		:	out	std_logic);
			
end enableKey;

architecture Behavioral of enableKey is

	signal	s_en	:	std_logic := '0';
	
begin

	en_proc:		process(enEn)
	
					begin
											
							if(rising_edge(enEn)) then
				
									s_en<= not s_en;
							end if;
						
					end process;
					
			en	<= std_logic(s_en);
					
end Behavioral;					
		