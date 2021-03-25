library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity PreCode2 is
		port	(	clk	:	in		std_logic;
					dig0	:	in		std_logic;
					dig1	:	in		std_logic;
					dig2	:	in		std_logic;
					set	:	in		std_logic;
					send	:	out	std_logic_vector(2 downto 0);
					en2	:	out	std_logic);
					
end PreCode2;

architecture Behavioral of PreCode2 is

	signal s_dig0	:	std_logic := '0';
	signal s_dig1	:	std_logic := '0';
	signal s_dig2	:	std_logic := '0';
	
	signal s_send	:	unsigned(std_logic_vector(2 downto 0));
begin

	comb_proc:	process(clk, s_dig0, s_dig1, s_dig2, dig0, dig1, dig2, set)
	
					 begin
							
						if(rising_edge(clk)) then
							if(set='0') then
								
								en2<='0';
								
								if(dig0='1') then
									s_dig0 <= not s_dig0;
								end if;
								
								if(dig1='1') then
									s_dig1 <= not s_dig1;
								end if;
								
								if(dig2='1') then
									s_dig2 <= not s_dig2;
								end if;
								
							else
								en2<='1';
								
							end if;
						end if;
						
						s_send <= s_dig2 & s_dig1 & s_dig0;
					
					 end process;
					
		send <= std_logic_vector(s_send);
		
end Behavioral;
					