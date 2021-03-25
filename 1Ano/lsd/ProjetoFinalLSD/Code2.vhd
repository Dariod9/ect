library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity Code2 is
	port( clk			:	in		std_logic;
			send			:	in		std_logic;
			sw1			:	in 	std_logic;
			sw2			:	in 	std_logic;
			sw3			:	in 	std_logic;
			ver			:	out	std_logic_vector(2 downto 0));

end Code2;

architecture Behavioral of Code2 is

	signal s_ver : unsigned(std_logic_vector(2 downto 0));
	
begin

	sync_proc:		process(clk, sw1, sw2, sw3)
	
							begin
															
								if(rising_edge(clk)) then
									
									if(send='1') then
								
										s_ver<=sw1 & sw2 & sw3;
									
									else
									
										s_ver<="000";
									end if;
									
								end if;
								
							end process;
				
			ver <= std_logic_vector(s_ver);
			
end Behavioral;				
