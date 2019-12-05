library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity Bin7SegState is
	port(binInput : in std_logic_vector(2 downto 0);
		  decOut1 : out std_logic_vector(6 downto 0);
		  decOut2 : out std_logic_vector(6 downto 0);
		  decOut3 : out std_logic_vector(6 downto 0));
end Bin7SegState;

architecture Behavioral of Bin7SegState is 
begin

	comb_proc:		process(binInput)

							begin
							
							decOut1<="1000000";
							
								if(binInput="000") then
									decOut2<="0001110";
									decOut3<="0001110";
								
								else
									decOut2<="0101011";
									
									if(binInput="010") then
										decOut3<="1111111";
									
									elsif(binInput="011") then 
										decOut3<="1001111";
								
									elsif(binInput="100") then							
										decOut3<="1001001";
									end if;
									
								end if;
			
							end process;

end Behavioral;