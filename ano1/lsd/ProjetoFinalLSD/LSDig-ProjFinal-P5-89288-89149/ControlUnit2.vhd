library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity ControlUnit2 is
		port(	--clk		:	in		std_logic;
				enable	:	in		std_logic;
				trig		:	in		std_logic;
				snd		:	in		std_logic;
				code1		:	in		std_logic;
				code2		:	in		std_logic_vector(1 downto 0);
				change	:	in		std_logic;
				C2			:	out	std_logic;
				C1			:	out	std_logic;
				T2			:	out	std_logic;
				T1			:	out	std_logic;
				T0			:	out	std_logic;
				stOut 	:	out	std_logic_vector(4 downto 0));
				
end ControlUnit2;

architecture Behavioral of ControlUnit2 is

	type state is (OFF, InputCode1, InputCode2, CodeOK, CodeNotOk);
	signal s_currentState, s_nextState	:	state;
	
begin
	
	
	--change_proc : process(clk)
		
		--begin
			--		if(rising_edge(clk)) then
				--		s_currentState <= s_nextState;
						
					--end if;
		--end process;
		
	
	def_proc	   : process(enable, trig, snd ,code1, code2)
	
	begin
			case (s_currentState) is
		
				when OFF	=>
					c2<='0';
					C1<='0';
					
					T2<='0';
					T1<='0';
					T0<='0';
					
					if(enable='1') then
						s_nextState <= InputCode1;
					else
						s_nextState <= s_currentState;
					end if;
				
				when InputCode1 =>
					C2<='0';
					C1<='1';
					
					T2<='1';
					T1<='0';
					T0<='1';
					
					if(enable='1' and trig='0' and code1='1') then
						s_nextState <= CodeOK;
					elsif(enable='0' and trig='0') then
						s_nextState <= CodeOK;
					else
						s_nextState <= s_currentState;
					end if;
					
					
				
				when InputCode2 =>
					C2<='1';
					C1<='0';
					
					T2<='1';
					T1<='1';
					T0<='0';
					
					if(enable='1') then
						if(trig<= '1' and code2="01") then
							s_nextState <= CodeNotOk;
						elsif(trig<='1' and code2="11") then
							s_nextState <= CodeOk;
						else
							s_nextState<= s_currentState;
						end if;
					else
							s_nextState<= OFF;
					end if;
					
					
				when CodeOk =>
					C2<='0';
					C1<='0';
					
					T2<='1';
					T1<='0';
					T0<='0';
	--			if(change='1')	then

					if(enable='1' and trig='1') then
						s_nextState <= InputCode2;
					elsif(enable='0' and trig='0' and snd='0') then
						s_nextState<= OFF;
					else
						s_nextState<= s_currentState;
					end if;
		--		else
				--	s_nextState<=s_currentState;
			--	end if;		
				
				when CodeNotOk =>
					C1<='0';
					C2<='1';
				
					T2<='1';
					T1<='1';
					T0<='1';
					
					if(enable='1') then
						if(trig='1' and code2="11") then
							s_nextState <= CodeOK;
						else
							s_nextState <= s_currentState;
						end if;
					else
						s_nextState <= OFF;
					end if;
			end case;

	end process;					
	
	with s_currentState select 
		
		stOut <= "00001" when OFF,
					"00010" when InputCode1,
					"00100" when InputCode2,
					"01000" when CodeNotOk,
					"10000" when CodeOK,
					"11110" when others;
						
end Behavioral;	
						