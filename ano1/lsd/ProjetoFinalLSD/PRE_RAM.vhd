library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity PRE_RAM is
	port(		en		:	in	std_logic;
				sw0	:	in	std_logic;
				sw1	:	in	std_logic;
				sw2	:	in	std_logic;
				sw3	:	in	std_logic;
				sw4	:	in	std_logic;
				sw5	:	in	std_logic;
				sw6	:	in	std_logic;
				sw7	:	in	std_logic;
				word	:	out std_logic_vector(2 downto 0);
				address_RAM :	out std_logic_vector(1 downto 0));

end PRE_RAM;

architecture Behavioral of PRE_RAM is

		signal s_word	:	std_logic_vector(2 downto 0);

begin
		
		process(en,sw0,sw1,sw2,sw3,sw4,sw5,sw6,sw7)
		
		begin
		
		 if(en='1') then
		
			address_RAM<="11";
		
			if(sw0='1') then
				s_word<="000";
		
			elsif(sw1='1') then
				s_word<="001";
			
			elsif(sw2='1') then
				s_word<="010";
			
			elsif(sw3='1') then
				s_word<="011";
			
			elsif(sw4='1') then
				s_word<="100";
			
			elsif(sw5='1') then
				s_word<="101";
			
			elsif(sw6='1') then
				s_word<="110";
			
			elsif(sw7='1') then
				s_word<="111";
			end if;
		 end if;		
		end process;

	word	<=	std_logic_vector(s_word);
		
end Behavioral;
					
				