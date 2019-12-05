library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity Switch is
	port(		clk	:	in	std_logic;
				sw0	:	in	std_logic;
				sw1	:	in	std_logic;
				sw2	:	in	std_logic;
				sw3	:	in	std_logic;
				trig	:	out std_logic;
				word	:	out std_logic_vector(2 downto 0));
				
end Switch;

architecture Behavioral of Switch is

		signal s_trig	:	std_logic;
		signal s_word	:	std_logic_vector(2 downto 0);

begin
		
		process(clk,sw0,sw1,sw2,sw3)
		
		begin
		 if(rising_edge(clk)) then
			s_trig <= '0';
			s_word <= "111";
				
			if(sw0='1') then
				s_trig<='1';
				s_word<="000";
		
			elsif(sw1='1') then
				s_trig<='1';
				s_word<="001";
			
			elsif(sw2='1') then
				s_trig<='1';
				s_word<="010";
			
			elsif(sw3='1') then
				s_trig<='1';
				s_word<="011";
			
			end if;
		 end if;
		end process;

	trig	<=	std_logic(s_trig);
	word	<= std_logic_vector(s_word);
		
end Behavioral;
					