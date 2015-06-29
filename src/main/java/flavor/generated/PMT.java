/* @flavorc
 *
 * PMT.java
 * 
 * This file was automatically generated by flavorc
 * from the source file:
 *     '../FormalDefs/PMT_section.fl'
 *
 * For information on flavorc, visit the Flavor Web site at:
 *     http://flavor.sourceforge.net
 *
 * -- Do not edit by hand --
 *
 */

package flavor.generated;
import flavor.*;
import java.io.*;

public class PMT {
    int table_id;
    int section_syntax_indicator;
    int private_indicator;
    int section_length;
    int program_number;
    int version_number;
    int current_next_indicator;
    int section_number;
    int last_section_numbe;
    int PCR_PID;
    int program_info_length;
    int remain_desc_bytes;
    Descriptor descriptor;
    int remain_section_bytes;
    PMTStream stream;
    int CRC_32;

    public int get(IBitstream _F_bs) throws IOException {
        int _F_ret = 0;
        MapResult _F_mr;
        int _F_parse = 0;
        Util.trace(_F_bs.getpos(), 0, (int)0, "begin PMT");
        _F_parse = 8;
        table_id = _F_bs.getbits(_F_parse);
        if (table_id != 2) {
            Util.flerror("Const value mismatch for 'table_id'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)table_id, "table_id" +  " (" + table_id + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)table_id, "table_id" +  " (" + table_id + ")");
        }
        _F_parse = 1;
        section_syntax_indicator = _F_bs.getbits(_F_parse);
        if (section_syntax_indicator != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_syntax_indicator, "section_syntax_indicator" +  " (" + section_syntax_indicator + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_syntax_indicator, "section_syntax_indicator" +  " (" + section_syntax_indicator + ")");
        }
        _F_parse = 1;
        private_indicator = _F_bs.getbits(_F_parse);
        if (private_indicator != 0) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)private_indicator, "private_indicator" +  " (" + private_indicator + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)private_indicator, "private_indicator" +  " (" + private_indicator + ")");
        }
        _F_bs.skipbits(2);
        _F_parse = 12;
        section_length = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_length, "section_length" +  " (" + section_length + ")");
        _F_parse = 16;
        program_number = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)program_number, "program_number" +  " (" + program_number + ")");
        _F_bs.skipbits(2);
        _F_parse = 5;
        version_number = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)version_number, "version_number" +  " (" + version_number + ")");
        _F_parse = 1;
        current_next_indicator = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)current_next_indicator, "current_next_indicator" +  " (" + current_next_indicator + ")");
        _F_parse = 8;
        section_number = _F_bs.getbits(_F_parse);
        if (section_number != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_number, "section_number" +  " (" + section_number + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_number, "section_number" +  " (" + section_number + ")");
        }
        _F_parse = 8;
        last_section_numbe = _F_bs.getbits(_F_parse);
        if (last_section_numbe != 0) {
            Util.flerror("Const value mismatch for 'last_section_numbe'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)last_section_numbe, "last_section_numbe" +  " (" + last_section_numbe + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)last_section_numbe, "last_section_numbe" +  " (" + last_section_numbe + ")");
        }
        _F_bs.skipbits(3);
        _F_parse = 13;
        PCR_PID = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)PCR_PID, "PCR_PID" +  " (" + PCR_PID + ")");
        _F_bs.skipbits(4);
        _F_parse = 12;
        program_info_length = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)program_info_length, "program_info_length" +  " (" + program_info_length + ")");
        remain_desc_bytes = program_info_length;
        while (remain_desc_bytes>0) {
            Util.trace(_F_bs.getpos(), 0, (int)0, "processing Descriptor descriptor");
            descriptor = new Descriptor();
            _F_ret += descriptor.get(_F_bs);
            remain_desc_bytes-=(descriptor._F_lengthof/8);
            if (1==0) break;
        }
        remain_section_bytes = section_length-program_info_length-9-4;
        while (remain_section_bytes>0) {
            Util.trace(_F_bs.getpos(), 0, (int)0, "processing PMTStream stream");
            stream = new PMTStream();
            _F_ret += stream.get(_F_bs);
            remain_section_bytes-=(stream._F_lengthof/8);
            if (1==0) break;
        }
        _F_parse = 32;
        CRC_32 = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)CRC_32, "CRC_32" +  " (" + CRC_32 + ")");
        Util.trace(_F_bs.getpos(), 0, (int)0, "end PMT");
        return _F_ret;
    }

    public int put(IBitstream _F_bs) throws IOException {
        int _F_ret = 0;
        MapResult _F_mr;
        int _F_parse = 0;
        _F_parse = 8;
        table_id = 2;
        _F_bs.putbits(table_id, _F_parse);
        _F_parse = 1;
        section_syntax_indicator = 1;
        _F_bs.putbits(section_syntax_indicator, _F_parse);
        _F_parse = 1;
        private_indicator = 0;
        _F_bs.putbits(private_indicator, _F_parse);
        _F_bs.skipbits(2);
        _F_bs.putbits(section_length, 12);
        _F_bs.putbits(program_number, 16);
        _F_bs.skipbits(2);
        _F_bs.putbits(version_number, 5);
        _F_bs.putbits(current_next_indicator, 1);
        _F_parse = 8;
        section_number = 0;
        _F_bs.putbits(section_number, _F_parse);
        _F_parse = 8;
        last_section_numbe = 0;
        _F_bs.putbits(last_section_numbe, _F_parse);
        _F_bs.skipbits(3);
        _F_bs.putbits(PCR_PID, 13);
        _F_bs.skipbits(4);
        _F_bs.putbits(program_info_length, 12);
        remain_desc_bytes = program_info_length;
        while (remain_desc_bytes>0) {
            _F_ret += descriptor.put(_F_bs);
            remain_desc_bytes-=(descriptor._F_lengthof/8);
            if (1==0) break;
        }
        remain_section_bytes = section_length-program_info_length-9-4;
        while (remain_section_bytes>0) {
            _F_ret += stream.put(_F_bs);
            remain_section_bytes-=(stream._F_lengthof/8);
            if (1==0) break;
        }
        _F_bs.putbits(CRC_32, 32);
        return _F_ret;
    }

    public int putxml(IBitstream _F_bs, boolean bAttr) throws IOException {
        int _F_ret = 0;
        MapResult _F_mr;
        int _F_parse = 0;
        _F_parse = 8;
        table_id = _F_bs.getbits(_F_parse);
        if (table_id != 2) {
            Util.flerror("Const value mismatch for 'table_id'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
            else {
                XML.WriteXmlElement("<table_id bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
            else {
                XML.WriteXmlElement("<table_id bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)table_id, "table_id" +  " (" + table_id + ")");
        }
        _F_parse = 1;
        section_syntax_indicator = _F_bs.getbits(_F_parse);
        if (section_syntax_indicator != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
            else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
            else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_syntax_indicator, "section_syntax_indicator" +  " (" + section_syntax_indicator + ")");
        }
        _F_parse = 1;
        private_indicator = _F_bs.getbits(_F_parse);
        if (private_indicator != 0) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
            else {
                XML.WriteXmlElement("<private_indicator bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
            else {
                XML.WriteXmlElement("<private_indicator bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)private_indicator, "private_indicator" +  " (" + private_indicator + ")");
        }
        _F_bs.skipbits(2);
        _F_parse = 12;
        section_length = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<section_length type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_length + "</section_length>");
        }
        else {
            XML.WriteXmlElement("<section_length bitLen=\"" + _F_parse + "\">" + section_length + "</section_length>");
        }
        _F_parse = 16;
        program_number = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<program_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + program_number + "</program_number>");
        }
        else {
            XML.WriteXmlElement("<program_number bitLen=\"" + _F_parse + "\">" + program_number + "</program_number>");
        }
        _F_bs.skipbits(2);
        _F_parse = 5;
        version_number = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<version_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + version_number + "</version_number>");
        }
        else {
            XML.WriteXmlElement("<version_number bitLen=\"" + _F_parse + "\">" + version_number + "</version_number>");
        }
        _F_parse = 1;
        current_next_indicator = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
        }
        else {
            XML.WriteXmlElement("<current_next_indicator bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
        }
        _F_parse = 8;
        section_number = _F_bs.getbits(_F_parse);
        if (section_number != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
            else {
                XML.WriteXmlElement("<section_number bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
            else {
                XML.WriteXmlElement("<section_number bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_number, "section_number" +  " (" + section_number + ")");
        }
        _F_parse = 8;
        last_section_numbe = _F_bs.getbits(_F_parse);
        if (last_section_numbe != 0) {
            Util.flerror("Const value mismatch for 'last_section_numbe'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<last_section_numbe type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + last_section_numbe + "</last_section_numbe>");
            }
            else {
                XML.WriteXmlElement("<last_section_numbe bitLen=\"" + _F_parse + "\">" + last_section_numbe + "</last_section_numbe>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<last_section_numbe type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + last_section_numbe + "</last_section_numbe>");
            }
            else {
                XML.WriteXmlElement("<last_section_numbe bitLen=\"" + _F_parse + "\">" + last_section_numbe + "</last_section_numbe>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)last_section_numbe, "last_section_numbe" +  " (" + last_section_numbe + ")");
        }
        _F_bs.skipbits(3);
        _F_parse = 13;
        PCR_PID = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<PCR_PID type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + PCR_PID + "</PCR_PID>");
        }
        else {
            XML.WriteXmlElement("<PCR_PID bitLen=\"" + _F_parse + "\">" + PCR_PID + "</PCR_PID>");
        }
        _F_bs.skipbits(4);
        _F_parse = 12;
        program_info_length = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<program_info_length type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + program_info_length + "</program_info_length>");
        }
        else {
            XML.WriteXmlElement("<program_info_length bitLen=\"" + _F_parse + "\">" + program_info_length + "</program_info_length>");
        }
        remain_desc_bytes = program_info_length;
        while (remain_desc_bytes>0) {
            Util.trace(_F_bs.getpos(), 0, (int)0, "processing Descriptor descriptor");
            descriptor = new Descriptor();
            XML.IntoAClass("descriptor", 0);
            _F_ret += descriptor.putxml(_F_bs, bAttr);
            XML.OutOfClass("</descriptor>");
            remain_desc_bytes-=(descriptor._F_lengthof/8);
            if (1==0) break;
        }
        remain_section_bytes = section_length-program_info_length-9-4;
        while (remain_section_bytes>0) {
            Util.trace(_F_bs.getpos(), 0, (int)0, "processing PMTStream stream");
            stream = new PMTStream();
            XML.IntoAClass("stream", 0);
            _F_ret += stream.putxml(_F_bs, bAttr);
            XML.OutOfClass("</stream>");
            remain_section_bytes-=(stream._F_lengthof/8);
            if (1==0) break;
        }
        _F_parse = 32;
        CRC_32 = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<CRC_32 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + CRC_32 + "</CRC_32>");
        }
        else {
            XML.WriteXmlElement("<CRC_32 bitLen=\"" + _F_parse + "\">" + CRC_32 + "</CRC_32>");
        }
        return _F_ret;
    }
}
