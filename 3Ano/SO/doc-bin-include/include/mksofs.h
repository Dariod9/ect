/**
 *  \file
 *  \brief The \b sofs19 formatting functions.
 *
 *  \author Artur Pereira - 2007-2009, 2016-2019
 *  \author Miguel Oliveira e Silva - 2009, 2017
 *  \author António Rui Borges - 2010-2015
 */

#ifndef __SOFS19_MKSOFS__
#define __SOFS19_MKSOFS__

#include <inttypes.h>

namespace sofs19
{
    /**
     * \defgroup mksofs mksofs
     * \brief Auxiliary formatting functions
     * @{ 
     * */

    /* ******************************************************************* */

    /**
     * \brief computes the structural division of the disk
     * \details The following should be observed:
     *     \li if \c itotal is zero, the value <code>ntotal / 16</code>
     *          should be used as a start value,
     *          where / stands for the integer division;
     *     \li \c itotal must be always lower than or equal to <code>ntotal / 8</code>;
     *     \li \c itotal must be rounded up to be multiple of \c IPB;
     * \param [in] ntotal Total number of blocks of the disk
     * \param [in, out] itotal Total number of inodes
     * \param [out] nbref Number of reference data blocks in a newly-formatted disk
     */
    void soComputeStructure(uint32_t ntotal, uint32_t & itotal, uint32_t & nbref);


    /**
     * \brief Fill in the fields of the superblock.
     * \details The following should be observed:
     *      \li the magic number should be put at \c 0xFFFF;
     *      \li The tail cache should be left empty;
     *      \li the head cache should be left filled (totally, if possible).      
     * \param [in] name volume name
     * \param [in] ntotal the total number of blocks in the device
     * \param [in] itotal the total number of inodes
     * \param [in] nbref Number of reference data blocks in a newly-formatted disk
     */
    void soFillSuperBlock(const char *name, uint32_t ntotal, uint32_t itotal, uint32_t nbref);


    /**
     * \brief Fill in the blocks of the inode table.
     * \details The following should be observed:
     *      \li inode table starts on block number 1;
     *      \li inode 0 must be filled assuming it is used by the root directory;
     *      \li all the other inodes are free;
     *      \li the first free inode should be inode number 1, the second inode number 2, and
     *                  do forth;
     *      \li the last free inode should point to NullReference.
     * \param [in] itotal the total number of inodes
     */
    void soFillInodeTable(uint32_t itotal, bool set_date = true);


    /**
     * \brief Fill in the data blocks containing references to free data blocks in
     *      a newly-formatted disk.
     * \details The following should be observed:
     *      \li the list of free data blocks is initially sorted in ascending order;
     *      \li the first references of the list are in the head cache;
     *      \li non-used cells must be filled with pattern NullReference;
     *      \li there is a possibility that for function to do nothing, in case all
     *              references fit in the head cache.
     * \param [in] ntotal the total number of blocks in the device
     * \param [in] itotal the total number of inodes
     * \param [in] nbref Number of reference data blocks in a newly-formatted disk
     */
    void soFillReferenceDataBlocks(uint32_t ntotal, uint32_t itotal, uint32_t nbref);
    

    /** 
     * \brief Fill in the root directory
     * \details The following should be observed:
     *      \li in a newly-formatted disk the root directory occupies a single, the 
     *              one immediately after the inode table;
     *      \li the first two slots must be filled in with
     *              \c "." and \c ".." directory entries.
     *      \li the other slots must be cleaned: 
     *              field \c name filled with zeros and field \c inode
     *              filled with \c NullReference.
     * \param [in] itotal the total number of inodes
     */
    void soFillRootDir(uint32_t itotal);


    /**
     * \brief Fill with zeros the free data blocks of a newly-formatted disk.
     * \param [in] ntotal the total number of blocks in the device
     * \param [in] itotal the total number of inodes
     * \param [in] nbref Number of reference data blocks in a newly-formatted disk
     */
    void soResetFreeDataBlocks(uint32_t ntotal, uint32_t itotal, uint32_t nbref);

    /* ***************************************** */

    /* ******************************************************************* */
    /** @} close group mksofs */
    /* ******************************************************************* */
};

#endif   /* __SOFS19_MKSOFS__ */
