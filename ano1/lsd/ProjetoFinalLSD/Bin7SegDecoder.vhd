library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity Bin7SegDecoder is
	port(binInput : in std_logic_vector(2 downto 0);
		  decOut_n : out std_logic_vector(6 downto 0));
end Bin7SegDecoder;

architecture Behavioral of Bin7SegDecoder is 
begin
	decOut_n <= "1111001" when (binInput = "001") else --1
					"0010101" when (binInput = "010") else --2
					"0110000" when (binInput = "011") else --3
					"0011001" when (binInput = "100") else --4
					"0010010" when (binInput = "101") else --5
					"0000010" when (binInput = "110") else --6
					"1111000" when (binInput = "111") else --7
					"1000000" when (binInput = "000"); --0
					
end Behavioral;