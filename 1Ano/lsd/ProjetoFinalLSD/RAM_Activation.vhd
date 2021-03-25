library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity RAM_Activation is	
	port(sw				:	in		std_logic_vector(1 downto 0);
		  address		:	in		std_logic_vector(1 downto 0);
		  writeEnable	:	in		std_logic;
		  writeData		:	in		std_logic_vector(2 downto 0); -- 8 palavras possíveis, uma para cada SWITCH ativado
		  readData		:	out	std_logic_vector(2 downto 0);
		  clk				:	in		std_logic);
		  
end RAM_Activation;

architecture Behavioral of RAM_Activation is
	
	subtype data_word is std_logic_vector(2 downto 0); -- palavra de 3 bits
	type t_RAM is array(0 to 3) of data_word;	-- array de 4 palavras
	
	signal RAMData : t_RAM;

	
begin

	process(clk,writeEnable)
	
		begin
		 if(rising_edge(clk)) then
				if(writeEnable='1') then
					
					RAMDATA(to_integer(unsigned(address)))	  <= RAMDATA(to_integer(unsigned(address))-1);
					RAMDATA(to_integer(unsigned(address))-1) <= RAMDATA(to_integer(unsigned(address))-2);
					RAMDATA(to_integer(unsigned(address))-2) <= RAMDATA(to_integer(unsigned(address))-3);
					RAMData(to_integer(unsigned(address))-3) <= writeData;
				
				end if;
							
				if(sw="00") then
					readData <= RAMDATA(to_integer(unsigned(address))-3);
				elsif(sw="01") then
					readData <= RAMDATA(to_integer(unsigned(address))-2);
				elsif(sw="10") then
					readData <= RAMDATA(to_integer(unsigned(address))-1);
				elsif(sw="11") then
					readData <= RAMDATA(to_integer(unsigned(address)));
				end if;
		 end if;
		end process;
	
end Behavioral;
	