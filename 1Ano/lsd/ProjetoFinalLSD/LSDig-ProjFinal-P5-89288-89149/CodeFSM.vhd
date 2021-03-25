library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity CodeFSM is
	port(	clk:		in		std_logic;
			enable:	in		std_logic;
			code:		out	std_logic_vector(2 downto 0);
			En2:		out	std_logic);

end CodeFSM;

architecture Behavioral of CodeFSM is

	type cState is (codeInt,codeCor);
	signal s_currentState, s_nextState	:	state;
	signal s_code	:	unsigned(2 downto 0) := "1001";
	
begin

	process(s_currentState, code)
		begin
			case (s_currentState) is
			
			when codeInt =>
				En2<='0';
				if(code="1111" and enable='1') then
					s_nextState <= codeCor;
				else
					s_nextState <= s_currentState;
				end if;
				
				
			when codeCor =>
				En2<='1';
				