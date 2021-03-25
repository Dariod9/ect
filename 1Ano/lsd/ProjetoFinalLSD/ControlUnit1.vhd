library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity ControlUnit1 is
		port(	clk		:	in		std_logic;
				reset		:	in		std_logic;
				
				enable	:	in		std_logic;
				trig		:	in		std_logic;
				snd		:	in		std_logic;
				
				title		:	out	std_logic_vector(2 downto 0);
				statez		:	out	std_logic_vector(17 downto 0);
				
				code1		:	in	std_logic;
				code2		:	in	std_logic_vector(2 downto 0);
				
				sAsk		:	out	std_logic;
				S2			:	out	std_logic;
				S1			:	out	std_logic;
				S0			:	out	std_logic);
				--stOut 	:	out	std_logic_vector(4 downto 0));
				
end ControlUnit1;

architecture Behavioral of ControlUnit1 is

	type state is (TurnedOff, TurnedOffAsk, TurnedOn , OnNoSound, OnSound);
	signal s_currentState, s_nextState	:	state;
	
begin

	change_proc : process(clk, reset)
	
	begin
				if (reset='1') then
					s_currentState <= TurnedOffAsk;
					
				elsif(rising_edge(clk)) then
					s_currentState <= s_nextState;
					
				end if;
	end process;
	
	
	def_proc:	process(s_currentState, enable, trig, snd, code1, code2)
	begin
	  case (s_currentState) is
		 
		 when TurnedOff =>
				sAsk<='0';
				s2<='0';
				s1<='0';
				s0<='0';
				title<="000";
				statez<="000000000000000000";
				
				if(enable='1') then
					s_nextState <= TurnedOffAsk;
				else
					s_nextState <= s_currentState;
				end if;		 
		 
		 
		 when TurnedOffAsk =>
				sAsk<='1';
				s2<='1';
				s1<='0';
				s0<='0';
				title<="000";
				statez<="000000000000000000";
				
			if(enable='1') then
					if	(code1='1') then
						s_nextState <=TurnedOn;
					else
						s_nextState <= s_currentState;
					end if;
			else
				s_nextState<= TurnedOff;
			end if;
				
		when TurnedOn =>
				sAsk<='0';
				s2<='1'; ----
				s1<='0';
				s0<='1'; 
				title<="010";
				statez<="000000000000000000";
				
			if(enable='1') then
				if (trig='1' and snd='0') then
					s_nextState <= OnNoSound;
				elsif (trig='1' and snd='1') then
					s_nextState <= OnSound;
				else
					s_nextState <= s_currentState;
				end if;
			else 
				s_nextState <= TurnedOff;
			end if;
				
		when OnNoSound =>
				sAsk<='0';
				s2<='1';
				s1<='1';
				s0<='0';
				title<="011";
				statez<="000000000111111111";
			
			if(enable='1') then
			
				if(snd='1') then
					s_nextState <= OnSound;
				elsif(code2="101") then
					s_nextState <= TurnedOn;
				elsif(code2/="101" and code2/="000") then
					s_nextState <= OnSound;
				else
					s_nextState <= s_currentState;
				end if;
			else
				s_nextState <= TurnedOff;
			end if;
				
		when OnSound =>
				sAsk<='0';
				s2<='1';
				s1<='1';
				s0<='1';
				title<="100";
				statez<="111111111111111111";
				
			if(enable='1') then
			
				if(code2="101") then
					s_nextState <= TurnedOn;
				else
					s_nextState <= s_currentState;
				end if;
			
			else
				s_nextState <= TurnedOff;
			end if;
			
	  end case;
	
	end process;  
	
	
		
		--stOut <= "00001" when TurnedOff,
			--		"00010" when TurnedOffAsk,
				--	"00100" when TurnedOn,
					--"01000" when OnNoSound,
					--"10000" when OnSound,
					--"11111" when others;
		

end Behavioral;				
				