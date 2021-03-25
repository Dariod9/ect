library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity wordMux is
		port	(	clk	:	in		std_logic;
					in1	:	in		std_logic_vector(2 downto 0);
					in2	:	in		std_logic_vector(2 downto 0);
					out0	:	out	std_logic_vector(2 downto 0));
end wordMux;


architecture Behavioral of wordMux is

	signal s_out0	:	std_logic_vector(2 downto 0);
	
begin

	sync_proc:	process(clk)
	
						begin
							
							if(rising_edge(clk)) then
								if(in1="111") then
									out0<=in2;
								end if;
								
								if(in2="000") then
									out0<=in1;
								end if;
							end if;
							
						end process;
end Behavioral;