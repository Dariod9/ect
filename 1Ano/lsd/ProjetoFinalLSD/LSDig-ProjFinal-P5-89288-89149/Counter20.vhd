library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity Counter20 is
	port( enable	:	in	 std_logic;
			clk		:	in	 std_logic;
			reset		:	in	 std_logic;
			trig		:	out std_logic);

end Counter20;

architecture Behavioral of Counter20 is

	signal s_seconds : unsigned(4 downto 0) := "10100";
	signal s_trig	  : std_logic := '0';
begin
	
	process(clk)
		begin
			if(rising_edge(clk)) then
				
				s_seconds <= s_seconds-1;
				
				if(reset='1') then
					s_seconds <= "10100";
				end if;
				
				if(s_seconds="00000") then
					s_trig <= '1';
				end if;
				
			end if;
		end process;

trig <= std_logic(s_trig);
		
end Behavioral;	