## Copyright (C) 2018 DarioMatos
## 
## This program is free software: you can redistribute it and/or modify it
## under the terms of the GNU General Public License as published by
## the Free Software Foundation, either version 3 of the License, or
## (at your option) any later version.
## 
## This program is distributed in the hope that it will be useful, but
## WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
## 
## You should have received a copy of the GNU General Public License
## along with this program.  If not, see
## <https://www.gnu.org/licenses/>.

## -*- texinfo -*- 
## @deftypefn {} {@var{retval} =} ScannerFile (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: DarioMatos <DarioMatos@DARIO-PC>
## Created: 2018-11-23

function array = ScannerFile (nome)

  file=fopen(nome);
  array=zeros(1,1,1,'utf8')
  
  while true
    line=fget1(file);
    
    if ~ischar(line)
      break;
    end
    
    words=strsplit(line)
    
    for i=1:length(words)
      str=erase(str,',');
      str=erase(str,'.');
      str=erase(str,"'");
      str=erase(str,"!");
      str=erase(str,"?");
      x(end+1)=str;
    end
  end
  
endfunction