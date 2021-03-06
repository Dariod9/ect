library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity SwitchInst is
	port(		clk	:	in	std_logic;
				sw4	:	in	std_logic;
				sw5	:	in	std_logic;
				sw6	:	in	std_logic;
				sw7	:	in	std_logic;
				trig	:	out std_logic;
				address: out std_logic_vector(1 downto 0);
				word	:	out std_logic_vector(2 downto 0));
				
end SwitchInst;

architecture Behavioral of SwitchInst is

		signal s_trig	:	std_logic;
		signal s_word	:	std_logic_vector(2 downto 0);

begin
		
		process(clk,sw4,sw5,sw6,sw7)
		
		begin
		 if(rising_edge(clk)) then
			address <= "11";
			s_trig <= '0';
			s_word <= "000";
							
			if(sw4='1') then
				s_trig<='1';
				s_word<="100";
			
			elsif(sw5='1') then
				s_trig<='1';
				s_word<="101";
			
			elsif(sw6='1') then
				s_trig<='1';
				s_word<="110";
			
			elsif(sw7='1') then
				s_trig<='1';
				s_word<="111";
			end if;
		 end if;
		end process;

	trig	<=	std_logic(s_trig);
	word	<= std_logic_vector(s_word);
		
end Behavioral;
					