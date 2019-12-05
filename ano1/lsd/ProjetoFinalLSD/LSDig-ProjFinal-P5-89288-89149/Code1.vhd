library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity Code1 is
	port( clk			:	in		std_logic;
			enable		:	in		std_logic;
			ver			:	out	std_logic);

end Code1;

architecture Behavioral of Code1 is

	signal s_ver : std_logic;
	
begin

	sync_proc:		process(clk,enable)
	
							begin
								if(rising_edge(clk)) then
									
									if(enable='1') then
										s_ver<='1';
									
									else
									
										s_ver<='0';
									end if;
								end if;	
							end process;
				
			ver <= std_logic(s_ver);
			
end Behavioral;				
