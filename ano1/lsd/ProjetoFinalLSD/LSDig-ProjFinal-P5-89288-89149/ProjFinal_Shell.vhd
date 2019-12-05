library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.NUMERIC_STD.all;

entity ProjFinal_Shell is
	port( SW			:	in	std_logic_vector(17 downto 0);
			KEY		:	in std_logic_vector(3 downto 0);
			CLOCK_50 :	in	std_logic;
			LEDR		:	out std_logic_vector(17 downto 0);
			HEX0     :  out std_logic_vector(6 downto 0);
			HEX1     :  out std_logic_vector(6 downto 0);
			HEX2     :  out std_logic_vector(6 downto 0);
			HEX3     :  out std_logic_vector(6 downto 0));
			
end ProjFinal_Shell;

architecture Shell of ProjFinal_Shell is

	signal s_en :	std_logic;

	signal clock:	std_logic;
	signal s_trig:	std_logic;
	signal s_trig_Inst:	std_logic;
	signal s_address: std_logic_vector(1 downto 0);
	signal s_address_Inst: std_logic_vector(1 downto 0);
	signal s_word:	std_logic_vector(2 downto 0);
	signal s_word_Inst: std_logic_vector(2 downto 0);
	
	signal c1sAsk:	std_logic;
	signal c1s2:	std_logic;
	signal c1s1:	std_logic;
	signal c1s0:	std_logic;
	signal c1state:	std_logic_vector(2 downto 0);
	
	signal word		:	std_logic_vector(2 downto 0);
	
	signal s_code1:	std_logic;
	
	signal s_code2:	std_logic_vector(2 downto 0);
	
	signal ram_read_data	: std_logic_vector(2 downto 0);
	
	
	
begin

	enEn	:	entity work.enableKey(Behavioral)
					port map (	clk	=> clock,
									enEn	=> not KEY(3),
									en		=> s_en);


	divisor:	entity work.clkDividerN(Behavioral)
					generic map(divFactor	=> 20000)
					port map ( 	clkIn			=>	CLOCK_50,
									clkOut		=>	clock);
									
	shift:	entity work.Switch(Behavioral)
					port map (	clk	=> clock,
									sw0	=> SW(0),
									sw1	=> SW(1),	
									sw2	=> SW(2),	
									sw3	=> SW(3),	
									trig	=> s_trig,
									word	=> s_word);
									
	shiftInst:	entity work.SwitchInst(Behavioral)
					port map (	clk	=> clock,	
									sw4	=> SW(4),	
									sw5	=> SW(5),	
									sw6	=> SW(6),	
									sw7	=> SW(7),
									trig	=> s_trig_Inst,
									address => s_address_Inst,
									word	=> s_word_Inst);
									
	C1Unit:	entity work.ControlUnit1(Behavioral)
					port map (	clk	=> clock,
									enable=> s_en,
									reset => SW(13),
									trig	=> s_trig or s_trig_Inst,
									snd	=> s_trig_Inst,-- and (not s_code2);
									sAsk	=> c1sAsk,
									code1	=>	s_code1,
									code2 => s_code2,
									title	=>	c1state,
									statez =>	LEDR(17 downto 0),
									S2		=> c1s2,
									S1		=> c1s1,
									s0		=> c1s0);
									
	hexState:entity work.Bin7SegState(Behavioral)
					port map (	binInput	=> c1state,
									decOut1	=>	HEX3,
									decOut2	=> HEX2,
									decOut3	=> HEX1);
																	
	CodE1:	entity work.Code1(Behavioral)
					port map (	clk		=> clock,
									enable	=> c1sAsk and SW(10),
									ver		=> s_code1);
									
	wodrMux: entity work.wordMux(Behavioral)
					port map (	clk		=> clock,
									in1		=> s_word,
									in2		=> s_word_Inst,
									out0		=> word);
									
	
	CodE2:	entity work.Code2(Behavioral)
					port map (	clk		=> clock,
									send		=> SW(17),
									sw1		=>	SW(16),
									sw2		=> SW(15),
									sw3		=> SW(14),
									ver		=> s_code2);
									
	RAM:		entity work.RAM_Activation(Behavioral)
					port map (	clk		=> clock,
									address	=> s_address,
									writeEnable	=>	c1s2 and c1s1 and c1s0,
									writeData	=> word,
									sw			=> SW(12 downto 11),
									readData	=> ram_read_data);
									
	Hex:		entity work.Bin7SegDecoder(Behavioral)
					port map	(	binInput => ram_read_data,
									decOut_n	=> HEX0);
									
									
end Shell;